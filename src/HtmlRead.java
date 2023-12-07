import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {
        // lucas helped me with this part since it wasn't working
        int endSpot=0;
        int indexSpot=0;
        int beginIndex =0;

        try {

            URL url = new URL("https://www.milton.edu/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if(line.contains("href=")){
                    System.out.println("og"+line);

                    if (line.contains("https")){
                        beginIndex = line.indexOf("https");
                    }
                    else if (line.contains("www")){
                        beginIndex = line.indexOf("www");
                    } else{
                        beginIndex=line.indexOf("href=")+6;
                    }



                    if (line.substring(beginIndex).contains("\'")){
                        endSpot = line.indexOf("\'", beginIndex+1);
                    }
                    if (line.substring(beginIndex).contains("\"")){
                        endSpot = line.indexOf("\"", beginIndex+1);
                    }
                    if (line.substring(beginIndex).contains("\"") && line.substring(beginIndex).contains("\'")){
                        if (line.indexOf("\'") > line.indexOf("\"")){
                            endSpot = line.indexOf("\"", beginIndex+1);
                        }else{
                            endSpot = line.indexOf("\'", beginIndex+1);
                        }
                    }
                    System.out.println(line.substring(beginIndex,endSpot));

//                     indexSpot = line.indexOf("href=");
//                     if(line.contains("\"")&&line.contains("www")){
//                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
//                        endSpot = endQuoteSpot;
//                         System.out.println(line.substring(indexSpot+6,endSpot));
//
//
//                      // System.out.println(line.substring(indexSpot+6,endQuoteSpot));
//
//                    }
//                    if(line.substring(indexSpot+6).contains("\'")){
//                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
//                        endSpot = singleQuoteSpot;
//
//
//                        //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));
//
//
//                    }
//                    if(line.substring(indexSpot+6).contains("\'")&&(line.substring(indexSpot+6).contains("\""))){
//                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
//                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
//
//                        if(singleQuoteSpot>endQuoteSpot){
//                           endSpot = endQuoteSpot;
//
//                        }
//                        else{
//                         //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));
//                             endSpot = singleQuoteSpot;
//
//                        }
//


                    //}






                }




            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }



}
