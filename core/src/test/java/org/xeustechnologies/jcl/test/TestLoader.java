package org.xeustechnologies.jcl.test;

import org.xeustechnologies.jcl.loader.ProxyClassLoader;

import java.io.InputStream;
import java.net.URL;

public class TestLoader extends ProxyClassLoader {

    @Override
    public Class loadClass(String className, boolean resolveIt) {
        return null;
    }

    @Override
    public InputStream loadResource(String name) {
        return null;
    }

    @Override
    public URL findResource(String name) {
        return null;
    }

}
