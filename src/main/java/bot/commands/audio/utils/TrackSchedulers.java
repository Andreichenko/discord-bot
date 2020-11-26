package bot.commands.audio.utils;

import com.google.common.collect.EvictingQueue;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TrackSchedulers extends AudioEventAdapter{

    private List<AudioTrack> queue = new ArrayList<>();
    private final Logger LOGGER = LogManager.getLogger(TrackSchedulers.class);

    private final EvictingQueue<AudioTrack> historyQueue = EvictingQueue.create(40);

    public void queue(AudioTrack track, boolean queueFirst){

    }
    public void clearQueue(){

    }
    public void setQueue(List<AudioTrack> queue){

    }
}
