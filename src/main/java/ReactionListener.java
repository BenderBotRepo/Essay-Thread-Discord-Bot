import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (event.getUser().isBot()) {
            return;
        }

        if (event.isFromType(ChannelType.PRIVATE)) {
            return;
        }

        Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();

        if (event.getEmoji().asUnicode().getAsCodepoints().equals("U+1f9f5")) {
            message.createThreadChannel("Essay Review").queue();
        }
    }
}
