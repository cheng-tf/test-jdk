package cn.edu.bupt.opensource.test.easyexcel.service;

import cn.edu.bupt.opensource.test.easyexcel.listener.ProjectUploadListener;
import cn.edu.bupt.opensource.test.easyexcel.model.ProjectUploadExcelModel;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.google.common.collect.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * @author chengtf
 * @date 2019/2/28
 */
public class EasyExcelTest {

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\cheng\\Desktop\\测试.xlsx";
        InputStream inputStream = new FileInputStream(new File(filePath));

        System.out.println("Start.");

        List<ProjectUploadExcelModel> projectUploadExcelModels = Lists.newArrayList();

        ProjectUploadListener listener = new ProjectUploadListener(projectUploadExcelModels);

        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);

        excelReader.read(new Sheet(1,1,ProjectUploadExcelModel.class));

        if (CollectionUtil.isNotEmpty(projectUploadExcelModels)) {
            projectUploadExcelModels.forEach(System.out::println);
        }


        System.out.println("True end.");

    }

}
