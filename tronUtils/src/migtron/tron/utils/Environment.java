/*
 *  Copyright (C) 2019 by Migtron Robotics   
 *  albarral@migtron.com
 */
package migtron.tron.utils;

import java.io.File;

/**
 * Utility class to manage operating system calls
 * @author albarral
 */
public class Environment 
{
    // obtains user's home path
    public static String getHomePath()
    {
        return System.getenv("HOME");
    }
    
    public static boolean cleanFolder(String path)
    {
        File folder = new File(path);
        // assure it's a folder
        if (folder.isDirectory())
        {
            File[] files = folder.listFiles();
            if (files != null) 
            {
                // delete each file in the folder
                for (File file : files)
                {
                    if (file.isFile())
                        file.delete();
                }
            }
            return true;
        }
        // if not a folder, skip
        else
            return false;
    }    
}
