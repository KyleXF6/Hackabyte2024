package mainCode;
public class BuddySystem {
	private String[] motivationalQuotes = {"You got this!", "You're doing great!", "Just believe in yourself!", "You can pull through!", "One more step!", 
			"Success is not final, failure is not fatal: It is the courage to continue that counts.",
			"Believe you can and you're halfway there.",
			"The only limit to our realization of tomorrow will be our doubts of today.",
			"It does not matter how slowly you go as long as you do not stop.",
			"The future belongs to those who believe in the beauty of their dreams.",
			"You are never too old to set another goal or to dream a new dream.",
			"Success is walking from failure to failure with no loss of enthusiasm.",
			"The only way to do great work is to love what you do.",
			"In the middle of difficulty lies opportunity.",
			"You don’t have to be great to start, but you have to start to be great.",
			"The journey of a thousand miles begins with one step.",
			"Opportunity does not knock, it presents itself when you beat down the door.",
			"The best way to predict the future is to create it.",
			"Don’t watch the clock; do what it does. Keep going.",
			"What you get by achieving your goals is not as important as what you become by achieving your goals."
			};
	private String[] facts = {"Regular physical activity among seniors reduces the risk of chronic diseases such as heart disease, stroke, type 2 diabetes, and certain cancers.",
			"Exercise helps maintain and increase muscle mass, which is crucial for maintaining strength and mobility as we age.",
			"Weight-bearing exercises such as walking, dancing, and strength training help maintain bone density and reduce the risk of osteoporosis and fractures.",
			"Participating in fitness activities can lead to social interaction and community involvement, reducing feelings of isolation and loneliness among seniors.",
			"Seniors who engage in regular physical activity tend to live longer and have a higher quality of life compared to sedentary individuals.",
			"Fitness programs for seniors often include low-impact activities that are gentle on joints, such as swimming, tai chi, and yoga.",
			"Balance exercises, such as standing on one foot or heel-to-toe walking, help improve stability and reduce the risk of falls.",
			"Regular physical activity helps seniors maintain a healthy weight and metabolism, reducing the risk of obesity and related health issues.",
			"Combined with a balanced diet, exercise supports overall health and well-being by providing essential nutrients and energy for daily activities."
	};
	
	public BuddySystem() {
		
	}
	
	public String[] getMoti() {
		return motivationalQuotes;
	}
	
	public String getMotivationalQuote() {
		int randomQuote = (int)(Math.random()*(motivationalQuotes.length));
		return motivationalQuotes[randomQuote];
	}
	
	public String[] getFacts(){
		return facts;
	}
	
	public String getAFact() {
		int randomQuote = (int)(Math.random()*(facts.length));
		return facts[randomQuote];
	}
	
	public String getMotivationalOrFact(String input) {
        if (input.indexOf("fact") != -1) {
            return getAFact();
        }
        return getMotivationalQuote();

    }
	
}
