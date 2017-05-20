package common.persistence.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class ExcelFile { 
    private MultipartFile file;

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
