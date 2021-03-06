package com.sdg.cmdb.service;


import com.sdg.cmdb.domain.BusinessWrapper;
import com.sdg.cmdb.domain.server.*;
import com.sdg.cmdb.domain.TableVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zxxiao on 16/9/1.
 */
public interface ServerGroupService {

    /**
     * 查询服务器组分页信息
     *
     * @param page
     * @param length
     * @param name
     * @param useType
     * @return
     */
    TableVO<List<ServerGroupVO>> queryServerGroupPage(int page, int length, String name, int useType);

    TableVO<List<ServerGroupVO>> queryUnauthServerGroupPage(int page, int length, String name, int useType);

    List<ServerGroupDO> queryLogServiceMemberPage(String name, long groupCfgId);

    /**
     * 查询项目管理服务器组分页信息
     *
     * @param page
     * @param length
     * @param name
     * @param useType
     * @return
     */
    TableVO<List<ServerGroupVO>> queryProjectServerGroupPage(int page, int length, String name, int useType);

    /**
     * 堡垒机服务器组分页数据查询
     *
     * @param name
     * @param page
     * @param length
     * @return
     */
    TableVO<List<ServerGroupVO>> queryKeyboxServerGroupPage(String name, int page, int length);

    /**
     * 更新服务器组信息
     *
     * @param serverGroupDO
     * @return
     */
    boolean updateServerGroupInfo(ServerGroupDO serverGroupDO);

    /**
     * 删除服务器信息
     *
     * @param id
     * @return
     */
    BusinessWrapper<Boolean> delServerGroupInfo(long id);

    /**
     * 服务器组绑定指定的ip组
     *
     * @param serverGroupId
     * @param ipGroupId
     * @param ipType
     * @return
     */
    BusinessWrapper<Boolean> addIPGroup(long serverGroupId, long ipGroupId, int ipType);

    /**
     * 服务器组解绑指定的ip组
     *
     * @param serverGroupId
     * @param ipGroupId
     * @return
     */
    BusinessWrapper<Boolean> delIPGroup(long serverGroupId, long ipGroupId);

    /**
     * 获取指定id的group
     *
     * @param serverGroupId
     * @return
     */
    ServerGroupDO queryServerGroupById(long serverGroupId);

    /**
     * 获取指定name的group
     *
     * @param serverName
     * @return
     */
    ServerGroupDO queryServerGroupByName(String serverName);

    /**
     * 获取指定用户名关联的服务器组列表
     *
     * @param username
     * @return
     */
    List<ServerGroupDO> getServerGroupsByUsername(String username);

    List<ServerGroupDO> getServerGroupsAll();


    /**
     * 查询服务器组使用类型分页信息
     *
     * @param typeName
     * @param page
     * @param length
     * @return
     */
    TableVO<List<ServerGroupUseTypeDO>> queryServerGroupUseTypePage(String typeName, int page, int length);

    /**
     * 查询服务器组使用类型列表
     * @return
     */
    List<ServerGroupUseTypeDO> queryServerGroupUseType();

    /**
     * 保存服务器组使用类型
     *
     * @param serverGroupUseTypeDO
     * @return
     */
    BusinessWrapper<Boolean> saveServerGroupUseType(ServerGroupUseTypeDO serverGroupUseTypeDO);


    BusinessWrapper<Boolean> delServerGroupUseType(long id);

    /**
     * 分组查询
     * @param groupId
     * @return
     */
    List<HostPattern> getHostPattern(long groupId);

    /**
     * 服务器完整分组
     * @param groupId
     * @return
     */
    Map<String, List<ServerDO>> getHostPatternMap(long groupId);

    List<GroupTree>  queryMyServerGroupList(String name);

    /**
     * 服务器分组（过滤）  如果有 env-1 则过滤掉 env
     * @param groupId
     * @return
     */
    Map<String, List<ServerDO>> getHostPatternFilterMap(long groupId);

    ServerGroupUseTypeDO getUseType(int useType);

    int getMyGroupSize();
}
