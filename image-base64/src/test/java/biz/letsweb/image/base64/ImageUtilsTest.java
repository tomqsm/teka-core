package biz.letsweb.image.base64;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import junit.framework.TestCase;

/**
 *
 * @author toks
 */
public class ImageUtilsTest extends TestCase {
    
    public ImageUtilsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of decodeToImage method, of class ImageUtils.
     * <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" alt="First slide">
     */
    public void testDecodeToImageTets() throws IOException {
        BufferedImage img = ImageIO.read(new File("src/main/resources/ajax-loader.gif"));
        String imgstr = ImageUtils.encodeToString(img, "gif");
        System.out.println("data:image/gif;base64," + imgstr);
    }

    /**
     * Test of encodeToString method, of class ImageUtils.
     */
    public void testEncodeToString() throws IOException {
        BufferedImage img = ImageIO.read(new File("src/main/resources/bcg.gif"));
        BufferedImage newImg;
        String imgstr;
        imgstr = ImageUtils.encodeToString(img, "gif");
        System.out.println(imgstr);
        newImg = ImageUtils.decodeToImage(imgstr);
        ImageIO.write(newImg, "gif", new File("src/main/resources/output/bcg.gif"));
    }
    
}
