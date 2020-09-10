package prilax.yk.service.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import prilax.yk.entity.common.Media;
import prilax.yk.error.exception.InternalServerException;
import prilax.yk.error.exception.NotFoundException;
import prilax.yk.util.Util;
import prilax.yk.vo.common.MediaFor;
import prilax.yk.vo.common.MediaVo;

@Service
public class MediaService {

    @Autowired
    private CommonService commonService;

    private final String uploadPath = MediaVo.MEDIA_PATH;

    private final Path rootLocation = Paths.get("upload");

    public Media store(MultipartFile file, String mediaFor, String mediaType, String id) throws Exception {

        String path = "";

        if (mediaFor.equals(MediaFor.PRODUCT))
            path = MediaFor.PRODUCT + File.separator + id;

        String relativeFilePath = path + File.separator + file.getOriginalFilename();
        String fullFilePath = this.uploadPath + File.separator + relativeFilePath;

        File dirFile = new File(this.uploadPath + File.separator + path);
        File fileToWrite = new File(fullFilePath);

        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        if (fileToWrite.exists()) {
            fileToWrite.delete();
        } else {
            fileToWrite.createNewFile();
        }

        file.transferTo(fileToWrite);

        Media media = new Media();

        media.setName(id);
        media.setPath(relativeFilePath);
        media.setType(mediaType);
        media = commonService.save(media);

        return media;

    }

    public Resource loadFile(String mediaId) {
        try {

            Media media = commonService.findById(mediaId, Media.class);

            if (!Util.isAllPresent(media))
                throw new NotFoundException("Media not found");

            Path filePath = Paths.get(this.uploadPath + File.separator + media.getPath());
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new InternalServerException("Failed to load resource");
            }
        } catch (MalformedURLException e) {
            throw new InternalServerException(e.getMessage());
        }
    }

    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new InternalServerException("Could not initialize storage!");
        }
    }
}
