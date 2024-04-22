package com.htht.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htht.common.exception.ServiceException;
import com.htht.system.domain.SysFile;
import com.htht.system.mapper.SysFileMapper;
import com.htht.system.service.ISysFileService;
import jodd.io.FileNameUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

/**
* @author lzs
* @description 针对表【upload_file】的数据库操作Service实现
* @createDate 2023-04-04 10:06:37
*/
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile>
    implements ISysFileService {

    private static final String[] banExtension = {"asp","jsp","aspx","php","exe","vbs","com"};

    @Override
    public SysFile upload(MultipartFile file, String absolutePath, String folder, boolean isStatics) {
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(0, fileName.lastIndexOf("."));
        if (Arrays.asList(banExtension).contains(extension)){
            throw new IllegalArgumentException("上传的文件不合法!");
        }
        Long size = file.getSize();
        SysFile uploadFileInfo = new SysFile();
        uploadFileInfo.setFileName(FileNameUtil.getBaseName(fileName));
        uploadFileInfo.setExtension(FileNameUtil.getExtension(fileName));
        uploadFileInfo.setTotalSize(size);

        String fileFolder = absolutePath + "/"+folder;
        File folderFile = new File(fileFolder);
        if (!folderFile.exists()) {
            folderFile.mkdirs();
        }

        String fileId = UUID.randomUUID().toString().replace("-", "");
        String newFileName = fileId + "." + FileNameUtil.getExtension(fileName);
        String filePath = fileFolder + "/" + newFileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        uploadFileInfo.setFilePath(filePath);
        uploadFileInfo.setIsStatic(isStatics?1:0);
        if (isStatics) {
            uploadFileInfo.setStaticPath(folder + "/" + newFileName);
        }
        this.save(uploadFileInfo);
        return uploadFileInfo;
    }

    @Override
    public void download(HttpServletResponse response, Long id) throws IOException {
        // 读到流中
        SysFile file = Optional.ofNullable(this.getById(id))
            .orElseThrow(() -> new ServiceException("文件不存在"));
        // 读到流中
        InputStream inputStream = new FileInputStream(file.getFilePath());// 文件的存放路径
        try {
//            response.reset();
            response.setContentType("application/octet-stream");
            String filename = new File(file.getFilePath()).getName();
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            //从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
            while ((len = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, len);
            }
        }catch (Exception e){
        }finally {
            inputStream.close();
        }
    }

    @Override
    public boolean delete(Long id) {

        // 读到流中
        SysFile sysFile = Optional.ofNullable(this.getById(id))
            .orElseThrow(() -> new ServiceException("文件不存在"));

        // Get the file path from the SysFile object
        String filePath = sysFile.getFilePath();

        // Initialize a File object
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists() && file.isFile()) {
            // Attempt to delete the file and return the result
            file.delete();
            return this.removeById(sysFile.getId());
        } else {
            return false;
        }
    }

}




