package bot.listeners;

import bot.commands.alias.GuildAlliasHolders;
import bot.services.implement.DiscordBotImplement;
import com.jagrosh.jdautilities.command.CommandClient;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class CommandEventListener extends ListenerAdapter{

    private final HashMap<String, GuildAlliasHolders> guildIdToGuildAliasHolderMap = new HashMap<>();

    private CommandClient commandClient;

    public void onMessageReceived(@Nonnull MessageReceivedEvent event){

        if (event.getAuthor().isBot()){

            return;
        }
        String guildID = event.getGuild().getId();
        GuildAlliasHolders guildAlliasHolders = guildIdToGuildAliasHolderMap.get(guildID);

        if (guildAlliasHolders == null) {

            return;
        }

        String rawContent = event.getMessage().getContentRaw();

        if (rawContent.startsWith(DiscordBotImplement.COMMAND_PREFIX)) {
            rawContent = rawContent.replace(DiscordBotImplement.COMMAND_PREFIX, "");

            if (guildAlliasHolders.doesAliasExistForCommand(rawContent)) {
                guildAlliasHolders.executeAlias(rawContent, event, commandClient);
            }
        }
    }

    public void putGuildAliasHolderForGuildWithId(String guildId, GuildAlliasHolders guildAlliasHolders){

        guildIdToGuildAliasHolderMap.put(guildId, guildAlliasHolders);
    }

    public void setCommandClient(CommandClient commandClient) {

        this.commandClient = commandClient;
    }
}
