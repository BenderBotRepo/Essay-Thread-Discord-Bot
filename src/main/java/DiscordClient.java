import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DiscordClient {
    final static String TOKEN = System.getenv("TOKEN");

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(TOKEN)
                .addEventListeners(new ReactionListener())
                .setActivity(Activity.watching("IELTS Study Group"))
                .build();

        jda.awaitReady();
    }
}
