
import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Test3 {
    public static void main (String args[]){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);
        camera.set(Videoio.CAP_PROP_FRAME_WIDTH, 1280);
        camera.set(Videoio.CAP_PROP_FRAME_HEIGHT, 720);

        if(!camera.isOpened()){
            System.out.println("Error");
        }
        else {
            int index = 0;
            Mat frame = new Mat();
            CascadeClassifier faceDetector = new CascadeClassifier("lbpcascade_frontalface.xml");

            while(true){
                if (camera.read(frame)){
                    System.out.println("Captured Frame Width " + frame.width() + " Height " + frame.height());

                    MatOfRect faceDetections = new MatOfRect();
                    faceDetector.detectMultiScale(frame, faceDetections);

                    for (Rect rect : faceDetections.toArray()) {
                        Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0));
                    }

                    Imgcodecs.imwrite("camera" + (index++) + ".jpg", frame);

                    System.out.println("OK");
                    break;
                }
            }
        }
        camera.release();
    }
}