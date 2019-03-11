/**
 * Copyright 2015 Kamran Zafar
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xeustechnologies.jcl.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.xeustechnologies.jcl.context.XmlContextLoader;

/**
 * 用于 web applications 从xml文件中加载 JCL context
 *
 * @author Kamran
 */
public class JclContextLoaderListener implements ServletContextListener {
    private static final String JCL_CONTEXT = "jcl-context";
    protected XmlContextLoader contextLoader;

    /**
     * 初始化
     */
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String config = context.getInitParameter(JCL_CONTEXT);

        contextLoader = new XmlContextLoader(config);
        contextLoader.addPathResolver(new WebAppPathResolver(context));
        contextLoader.loadContext();
    }

    /**
     * Destroys the context
     */
    public void contextDestroyed(ServletContextEvent sce) {
        contextLoader.unloadContext();
    }
}
