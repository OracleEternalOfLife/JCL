package org.xeustechnologies.jcl;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CLTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/michael/codes/codes-tmp/JCL/JCL2/test-jcl/target/test-jcl-2.9-SNAPSHOT.jar");
        URL url = file.toURI().toURL();//将File类型转为URL类型，file为jar包路径
        URLClassLoader loader = new URLClassLoader(new URL[]{url});

        Class c = loader.loadClass("org.xeustechnologies.jcl.test.Test");
        System.out.println(c);

    }
}
