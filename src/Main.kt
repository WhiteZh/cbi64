import java.awt.Image
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.util.Base64
import javax.imageio.ImageIO

fun main(): Unit =
    try {
        Toolkit.getDefaultToolkit().systemClipboard.let { clipboard ->
            clipboard.getData(DataFlavor.imageFlavor).let { img ->
                when (img) {
                    is Image -> BufferedImage(
                        img.getWidth(null),
                        img.getHeight(null),
                        BufferedImage.TYPE_INT_RGB
                    ).apply {
                        graphics.drawImage(img, 0, 0, null)
                    }.let { bi ->
                        ByteArrayOutputStream().also { baos ->
                            ImageIO.write(bi, "JPEG", baos)
                        }.toByteArray()
                    }.let { ba ->
                        Base64.getEncoder().encodeToString(ba)
                    }.let { s ->
                        "data:image/jpeg;base64,$s"
                    }.let { dataUrl ->
                        clipboard.setContents(StringSelection(dataUrl), null)
                    }.run {
                        println("Image in clipboard has being successfully converted and pasted back to clipboard.")
                    }

                    else -> {
                        println("Unexpected data type from clipboard`: ${img.javaClass}.")
                    }
                }
            }
        }
    } catch (e: UnsupportedFlavorException) {
        println("Clipboard does not currently contain image.")
    }