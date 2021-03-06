package com.shoumipay.service.admin;

import com.shoumipay.domain.RolePermission;

import java.util.List;

public interface RolePermissionService {
    /**
     * 根据roleid查询
     */
    List<RolePermission> findByRoleId(Long roleId);

    /**
     * del
     */
    int delRolePermission(RolePermission rp);

    /**
     * add
     */

    int addRolePermission(RolePermission rp);


}