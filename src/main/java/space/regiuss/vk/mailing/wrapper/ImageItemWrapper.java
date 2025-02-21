package space.regiuss.vk.mailing.wrapper;

import javafx.scene.image.Image;
import lombok.Data;

@Data
public class ImageItemWrapper<T> {
    protected T item;
    protected Image image;

    public ImageItemWrapper(T item) {
        this.item = item;
    }
}
