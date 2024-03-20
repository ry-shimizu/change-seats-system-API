package com.changeSeat.Mapper;

import com.changeSeat.Model.SiteUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SiteUserMapper {

    void insert(SiteUser siteUser);
}
