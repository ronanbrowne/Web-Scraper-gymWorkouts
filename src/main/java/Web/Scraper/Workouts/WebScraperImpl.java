package Web.Scraper.Workouts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraperImpl implements webScraper {

	public WebScraperImpl() {
	}

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("http://southdublinsc.ie/blog/").get();

		Element elementByID = doc.getElementById("post-7595");
		Elements workout = elementByID.getElementsByClass("wtrBlogPostSneakPeakLead");

		if (workout != null) {
			System.out.println(formatText(workout.html()));
		} else {
			System.out.println("no workout available");
		}

	}
	
	private static String formatText(String retrievedHTML) {
		
		String workout = "";
		
		if(retrievedHTML.startsWith("Workout A1")) {
			workout =retrievedHTML.replace("Workout A1", "Workout A1\n");
		}
		return workout.replace(';', '\n');
	}

}
