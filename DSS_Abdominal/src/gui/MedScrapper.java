package gui;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.List;

public class MedScrapper {

    public static void main(String[] args) {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        try {
            //HtmlPage page = webClient.getPage("https://www.mayoclinic.org/diseases-conditions/crohns-disease/symptoms-causes/syc-20353304");
            HtmlPage page = webClient.getPage("https://www.mayoclinic.org/diseases-conditions/inguinal-hernia/symptoms-causes/syc-20351547");
            //HtmlPage page = webClient.getPage("https://www.mayoclinic.org/diseases-conditions/diverticulitis/symptoms-causes/syc-20371758");

            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            webClient.getOptions().setPrintContentOnFailingStatusCode(false);


            //selecting all headings
            List<HtmlParagraph> paragraphs =  page.getByXPath("//div[@class='content']/div/p");
            System.out.println(paragraphs.get(0).asNormalizedText());
            System.out.println(paragraphs.get(1).asNormalizedText());

            /*System.out.println("title: "+page.getTitleText());
            DomElement element = page.getElementById("main-content").getChildElements().iterator().next();
            for ( DomElement child : element.getChildElements()) {
                //System.out.println("Element name: " + child.getNodeName());
                //System.out.println("Element Id: " + child.getId());
                String content = child.asNormalizedText();
                String content_interested_in = content.substring(content.indexOf("Overview")+9, content.indexOf("Products & Services"));
                System.out.println("Element content:\n\n" + content_interested_in);
            }*/


            webClient.getCurrentWindow().getJobManager().removeAllJobs();
            webClient.close();
            //recipesFile.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }

}
