import org.opencv.core.Core;

public class BackgroundSubtractionDemo {
    public static void main(String[] args) {
        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        new BackgroundSubtraction().run(args);
    }
}
