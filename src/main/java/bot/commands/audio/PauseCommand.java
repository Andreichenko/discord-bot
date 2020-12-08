package bot.commands.audio;

import bot.commands.audio.utils.VoiceChannel;
import bot.commands.text.TextCommand;
import bot.utils.ChannelTextResponses;
import bot.utils.UnicodeMotion;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PauseCommand extends Command {

    private final Logger LOGGER = LogManager.getLogger(PauseCommand.class);

    public PauseCommand(){
        this.name = "pause";
        this.help = "Pause the currently playing song.";
    }

    @Override
    protected void execute(CommandEvent event){

        try {
            VoiceChannel.setPauseStatusOnAudioPlayer(event.getGuild(), event.getChannel(), event.getMember(), true);
        }catch(IllegalArgumentException e){
            LOGGER.debug("Trying to pause a paused song", e);
            event.getChannel().sendMessage(ChannelTextResponses.TRYING_TO_PAUSE_PAUSED_SONG).queue();
            return;
        } catch(IllegalAccessException e){
            LOGGER.debug("Error while running pause command", e);
            return;
        }

        event.getMessage().addReaction(UnicodeMotion.THUMBS_UP).queue();

    }
}