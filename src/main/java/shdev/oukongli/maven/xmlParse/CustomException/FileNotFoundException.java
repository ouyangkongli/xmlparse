package shdev.oukongli.maven.xmlParse.CustomException;

/**
 * Created by kouyang on 12/3/2014.
 */
public class FileNotFoundException extends Exception{
    public String getMessage(){
        return message;
    }

    private String message;

    public void setMessage(String message){
        this.message = message;
    }

    public FileNotFoundException(String message){
        this.message = message;
    }
}
