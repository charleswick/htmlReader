import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        int endSpot=0;
        int indexSpot=0;

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("href=")){
                     indexSpot = line.indexOf("href=");

                    if(line.substring(indexSpot+6).contains("\"")&&line.substring(indexSpot+6).contains("www")){
                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
                        endSpot = endQuoteSpot;
                      //  System.out.println(line.substring(indexSpot+6,endQuoteSpot));

                    }
                    if(line.substring(indexSpot+6).contains("\'")&&line.substring(indexSpot+6).contains("www")){
                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
                        endSpot = singleQuoteSpot;
                     //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));


                    }
                    if(line.substring(indexSpot+6).contains("\'")&&line.substring(indexSpot+6).contains("www")&&(line.substring(indexSpot+6).contains("\""))){
                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
                        if(singleQuoteSpot>endQuoteSpot){
                           endSpot = endQuoteSpot;

                        }
                        else{
                         //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));
                             endSpot = singleQuoteSpot;

                        }



                    }





                }
                System.out.println(line.substring(indexSpot+6,endSpot));



            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }



}
