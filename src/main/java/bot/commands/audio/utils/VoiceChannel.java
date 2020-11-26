package bot.commands.audio.utils;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.managers.AudioManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VoiceChannel {

    private static final Logger LOGGER = LogManager.getLogger(VoiceChannel.class);

    public static void joinVoiceChannel(Member member,
                                        Guild guild,
                                        AudioPlayerManager playerManager)
            throws IllegalArgumentException, InsufficientPermissionException {

        GuildVoiceState memberVoiceState = member.getVoiceState();

        AudioManager audioManager = guild.getAudioManager();




    }
}

