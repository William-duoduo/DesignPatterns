package main.java.AdapterMethod;

// 已有的MediaPlayer接口和其实现类
interface MediaPlayer {
    void play(String audioType, String fileName);
}

class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        if ("mp3".equalsIgnoreCase(audioType)) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// 新的高级媒体播放接口及其实现类
interface AdvancedMediaPlayer {
    void playAvi(String fileName);
}

class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        System.out.println("Playing avi file. Name: " + fileName);
    }
}

// 适配器类，使AdvancedMediaPlayer适应MediaPlayer接口
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter() {
        advancedMusicPlayer = new AviPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("avi".equalsIgnoreCase(audioType)) {
            advancedMusicPlayer.playAvi(fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported by adapter");
        }
    }
}

// 扩展原始播放器以支持更多类型
class ExtendedAudioPlayer extends AudioPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        // 对于mp3类型，直接播放
        if ("mp3".equalsIgnoreCase(audioType)) {
            super.play(audioType, fileName);
        }
        // 对于其他类型，通过适配器播放
        else if ("avi".equalsIgnoreCase(audioType)) {
            mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// 测试类
public class AdapterPatternDemo {
    public static void main(String[] args) {
        ExtendedAudioPlayer audioPlayer = new ExtendedAudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("avi", "alone.avi");
        audioPlayer.play("mkv", "alone.mkv"); // 不支持的格式
    }
}