package com.github.uuidcode.junit5.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DomainConverter {
    /**
     *  local.studio.storyfunding.devel.kakao.com
     *  -> local-studio-storyfunding.devel.kakao.com
     */
    public String toHttpsDomain(String domain) {
        List<String> list = Arrays.asList(domain.split("\\."));

        int size = 4;

        if (list.size() > size) {
            List<String> prefixList = list.subList(0, list.size() - size);
            List<String> suffixList = list.subList(list.size() - size, list.size());
            return prefixList.stream().collect(Collectors.joining("-")) +
                "-" +
                suffixList.stream().collect(Collectors.joining("."));
        } else {
            return domain;
        }
    }
}
