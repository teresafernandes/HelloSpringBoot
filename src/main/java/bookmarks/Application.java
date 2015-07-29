package bookmarks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	CommandLineRunner init(final AccountRepository accountRepository,
			final BookmarkRepository bookmarkRepository) {
		
		return new CommandLineRunner() {
	        @Override
	        public void run(String... arg0) throws Exception {
	        	String accounts = "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong";
	    		String[] accountsArray = accounts.split(",");
	    		for(String s: accountsArray){
	    			Account account = accountRepository.save(new Account(s,
	    					"password"));
	    			bookmarkRepository.save(new Bookmark(account,
	    					"http://bookmark.com/1/" + s, "A description"));
	    			bookmarkRepository.save(new Bookmark(account,
	    					"http://bookmark.com/2/" + s, "A description"));
	    		}
	          
	        }
	      };
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}