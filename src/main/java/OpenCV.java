

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class OpenCV {
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);
//        camera.set(Videoio.CV_CAP_PROP_FRAME_WIDTH, 1280);
//        camera.set(Videoio.CV_CAP_PROP_FRAME_HEIGHT, 720);

        if (!camera.isOpened()) {
            System.out.println("Error");
        } else {
            int index = 0;
            Mat frame = new Mat();
            while (true) {
                if (camera.read(frame)) {
                    System.out.println("Captured Frame Width " + frame.width() + " Height " + frame.height());

                    Imgcodecs.imwrite("camera" + (index++) + ".jpg", frame);

                    System.out.println("OK");
                    break;
                }
            }
        }
        camera.release();
    }
}
