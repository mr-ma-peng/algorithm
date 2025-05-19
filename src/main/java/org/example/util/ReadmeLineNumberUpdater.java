package org.example.util;

import com.github.javaparser.JavaParser;
import com.github.javaparser.Position;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * README.md行号更新工具
 * 该工具扫描Java源文件，提取方法定义位置，并更新README.md中对应的行号
 */
public class ReadmeLineNumberUpdater {
    private static final Logger logger = Logger.getLogger(ReadmeLineNumberUpdater.class.getName());
    public static Map<String, Integer> extractMethodLineNumbers(String javaFilePath) throws IOException {
        Map<String, Integer> methodLineNumbers = new HashMap<>();
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try (FileInputStream in = new FileInputStream(javaFilePath)) {
            var result = javaParser.parse(in).getResult();
            if (result.isPresent()) {
                cu = result.get();
            } else {
                throw new IOException("无法解析Java文件");
            }
        }

        new MethodVisitor().visit(cu, methodLineNumbers);

        return methodLineNumbers;
    }

    private static class MethodVisitor extends VoidVisitorAdapter<Map<String, Integer>> {
        @Override
        public void visit(MethodDeclaration md, Map<String, Integer> methodLineNumbers) {
            super.visit(md, methodLineNumbers);
            Optional<Position> position = md.getBegin();
            if (position.isPresent()) {
                methodLineNumbers.put(md.getNameAsString(), position.get().line);
            } else {
                logger.log(Level.INFO, "方法 {} 没有起始位置信息", md.getNameAsString());
            }
        }
    }

    public static void updateReadme(String readmePath, String moduleName, Map<String, Integer> methodLineNumbers) throws IOException {
        Path path = Paths.get(readmePath);
        List<String> readmeLines = Files.readAllLines(path);
        // 处理每个方法行号
        for (Map.Entry<String, Integer> entry : methodLineNumbers.entrySet()) {
            String methodName = entry.getKey();
            int lineNumber = entry.getValue();

            // 使用更简单的正则表达式模式
            String patternString = "^(\\d+)\\.\\s\\[(" + methodName + ")\\((.*?)\\)]\\((.*?/" + moduleName + "/.*?\\.java)#L(\\d+)\\)$";
            Pattern pattern = Pattern.compile(patternString);

            // 替换行号
            for (int i = 0; i < readmeLines.size(); i++) {
                String line = readmeLines.get(i);
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String replacement = matcher.group(1) + ". [" + matcher.group(2) + "(" + matcher.group(3) + ")](" + matcher.group(4) + "#L" + lineNumber + ")";
                    readmeLines.set(i, matcher.replaceAll(replacement));
                }
            }
        }
        // 写回README.md
        Files.write(path, readmeLines);
    }

    public static void main(String[] args) {
        try {
            String currentDir = System.getProperty("user.dir");
            String[] modules = {"array", "string", "linkedlist", "search", "tree"};
            String readmePath = Paths.get(currentDir, "README.md").toString();

            for (String module : modules) {
                String javaFilePath = Paths.get(currentDir, "src", "main", "java", "org", "example", module, "Solution.java").toString();
                Map<String, Integer> methodLineNumbers = extractMethodLineNumbers(javaFilePath);
                updateReadme(readmePath, module, methodLineNumbers);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}