package com.txliu.demo.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * classLoader 获取jar包内的内容 maven依赖的jar包内容
 *
 * @author txliu
 * @date 2022/5/20
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws IOException {
        String file = "com";
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        String[] allResource = getAllResource(file, classLoader);
        for (String s : allResource) {
            List<String> strings = IOUtils.readLines(classLoader.getResourceAsStream(s));
        }


    }

    /**
     * 获取资源目录下的全部资源
     *
     * @param dirName     根目录
     * @param classLoader 加载器
     * @return 资源集合
     */
    public static String[] getAllResource(String dirName, ClassLoader classLoader) {
        Set<String> result = new HashSet<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(dirName);
            while (resources.hasMoreElements()) {
                result.addAll(getAllResource(dirName, resources.nextElement()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toArray(new String[0]);

    }

    public static Set<String> getAllResource(final String dirName, URL url) {
        final Set<String> resources = new HashSet<>();
        if (url == null) {
            return resources;
        }
        if (url.getProtocol().equals("file")) {

        } else if (url.getProtocol().equals("jar")) {
            getAllResourceInJar(dirName, url, resources);
        }
        return resources;
    }

    public static void getAllResourceInFile(final String dirname, URL url, final Set<String> resources) {
        try {
            File file = new File(URLDecoder.decode(url.getPath(),"UTF-8"));
            Collection<File> files = FileUtils.listFiles(file, FileFilterUtils.suffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
            for (File file1 : files) {
                if (!file1.isDirectory() && file1.getPath().contains(dirname)) {
                    resources.add(file1.getPath());
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    public static void getAllResourceInJar(final String dirName, URL url, Set<String> resources) {
        String jarPathURL = url.getPath();
        String jarPath = jarPathURL.substring(jarPathURL.indexOf("/"), jarPathURL.indexOf("!"));
        try (JarFile jarFile = new JarFile(URLDecoder.decode(jarPath, "UTF-8"))) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = entries.nextElement();
                String name = jarEntry.getName();
                if (!jarEntry.isDirectory() && name.contains(dirName)) {
                    resources.add(name);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
