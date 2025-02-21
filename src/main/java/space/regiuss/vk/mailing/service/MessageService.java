package space.regiuss.vk.mailing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.regiuss.vk.mailing.model.Message;
import space.regiuss.vk.mailing.model.MessageKit;
import space.regiuss.vk.mailing.repository.MessageKitRepository;
import space.regiuss.vk.mailing.repository.MessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageKitRepository messageKitRepository;
    private final MessageRepository messageRepository;

    @Transactional(readOnly = true)
    public List<MessageKit> getAllKits() {
        return messageKitRepository.findAll();
    }

    @Transactional
    public MessageKit save(MessageKit messageKit) {
        return messageKitRepository.save(messageKit);
    }

    @Transactional
    public void editKitName(MessageKit kit, String name) {
        kit.setName(name);
        messageKitRepository.save(kit);
    }

    @Transactional
    public void delete(MessageKit kit) {
        messageKitRepository.delete(kit);
    }

    @Transactional
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Transactional
    public void delete(Message message) {
        /*MessageKit kit = message.getMessageKit();
        if (kit != null) {
            kit.getMessages().remove(message);
            save(kit);
        }*/
        messageRepository.delete(message);
    }

    @Transactional(readOnly = true)
    public List<Message> getMessagesByKit(int kitId) {
        return messageKitRepository.findAllMessagesByKit(kitId);
    }

    @Transactional(readOnly = true)
    public MessageKit findById(int id) {
        return messageKitRepository.findById(id).get();
    }
}
