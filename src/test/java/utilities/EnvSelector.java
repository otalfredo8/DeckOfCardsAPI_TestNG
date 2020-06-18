package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EnvSelector {
    public static Map<String, String> envMap = new HashMap<String, String>();
    private static Properties properties = new Properties();

    public static Map<String, String> envFileSelected (){

        String sysProperKey = System.getProperty("env"); //property key to edit Run Config

        try {
            FileInputStream fileInputStreamDEV = new FileInputStream(System.getProperty("user.dir") + "/config_systemproperties/dev1.properties");

            if (sysProperKey.equalsIgnoreCase("dev1")){ //property value to edit Run Config
                properties.load(fileInputStreamDEV);
                envMap.put("ServerUrl", properties.getProperty("deckOfCardsURI"));
                //!!! if required, token, port, auth credentials

            }
            if (sysProperKey.equalsIgnoreCase("dev2")){
                FileInputStream fileInputStreamQA = new FileInputStream(System.getProperty("user.dir")+"/config_systemproperties/dev2.properties");
                properties.load(fileInputStreamQA);
                envMap.put("ServerUrl", properties.getProperty("deckOfCardsURI"));
                //!!! if required, token, port, auth credentials

            }
            if (sysProperKey.equalsIgnoreCase("dev3")){
                FileInputStream fileInputStreamSTAGING = new FileInputStream(System.getProperty("user.dir") + "/config_systemproperties/dev3.properties");
                properties.load(fileInputStreamSTAGING);
                envMap.put("ServerUrl", properties.getProperty("deckOfCardsURI"));
                //!!! if required, token, port, auth credentials

            }
        }catch (FileNotFoundException filenotfoundexception){
            filenotfoundexception.fillInStackTrace();
        }catch (IllegalArgumentException illegalArgumentException){
            illegalArgumentException.fillInStackTrace();
        }catch (SecurityException securityException){
            securityException.fillInStackTrace();
        }catch (IOException ioException){
            ioException.fillInStackTrace();
        }
        return envMap;
    }
}
