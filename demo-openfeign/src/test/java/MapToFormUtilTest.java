import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.api.util.MapToFormUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapToFormUtilTest {

    @Test
    void subListMapToForm() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("caseSeqno", 123.0);
        dataMap.put("step", "03");
        dataMap.put("twdAccount", false);
        dataMap.put("forignAccount", false);
        dataMap.put("trustAccount", true);
        dataMap.put("debitCard", false);

        List<Map<String, Object>> addItems = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("itemType", "12");
        item.put("itemContent", "123");
        addItems.add(item);

        dataMap.put("addItems", addItems);
        log.debug("res: Map = {}", dataMap);
        log.debug("res: mapToFormData = {}",  MapToFormUtil.mapToFormData(dataMap,StandardCharsets.UTF_8));
    }

    @Test
    void listMapToForm() {
        List<Map<String, Object>> addItems = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("itemType", "12");
        item.put("itemContent", "123");
        addItems.add(item);
        item.put("itemType", "1001");
        item.put("itemContent", "2002");
        addItems.add(item);
        log.debug("res: Map = {}", addItems);
        log.debug("res: listMapToFormData = {}",  MapToFormUtil.listMapToFormData("addItems",addItems,StandardCharsets.UTF_8));
    }

    @Test
    void objOfMapToForm() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("caseSeqno", 0.0);
        Map<String, String> subMap = new HashMap<>();
        subMap.put("amt", "amt001");
        subMap.put("mac", "amc001");
        dataMap.put("verifyOtpReq", subMap);
        log.debug("res: Map = {}", dataMap);
        log.debug("res: dataMap = {}",  MapToFormUtil.mapToFormData(dataMap,StandardCharsets.UTF_8));
    }
}