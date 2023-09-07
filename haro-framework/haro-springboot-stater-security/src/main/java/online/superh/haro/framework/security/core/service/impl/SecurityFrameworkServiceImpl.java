package online.superh.haro.framework.security.core.service.impl;

import online.superh.haro.framework.security.core.service.SecurityFrameworkService;

/**
 * @version: 1.0
 * @author: haro
 * @description:
 * @date: 2023-09-05 18:15
 */
public class SecurityFrameworkServiceImpl implements SecurityFrameworkService {

    // private final PermissionApi permissionApi;

    // /**
    //  * 针对 {@link #hasAnyRoles(String...)} 的缓存
    //  */
    // private final LoadingCache<KeyValue<Long, List<String>>, Boolean> hasAnyRolesCache = CacheUtils.buildAsyncReloadingCache(
    //         Duration.ofMinutes(1L), // 过期时间 1 分钟
    //         new CacheLoader<KeyValue<Long, List<String>>, Boolean>() {
    //
    //             @Override
    //             public Boolean load(KeyValue<Long, List<String>> key) {
    //                 return permissionApi.hasAnyRoles(key.getKey(), key.getValue().toArray(new String[0])).getCheckedData();
    //             }
    //
    //         });
    //
    // /**
    //  * 针对 {@link #hasAnyPermissions(String...)} 的缓存
    //  */
    // private final LoadingCache<KeyValue<Long, List<String>>, Boolean> hasAnyPermissionsCache = CacheUtils.buildAsyncReloadingCache(
    //         Duration.ofMinutes(1L), // 过期时间 1 分钟
    //         new CacheLoader<KeyValue<Long, List<String>>, Boolean>() {
    //
    //             @Override
    //             public Boolean load(KeyValue<Long, List<String>> key) {
    //                 return permissionApi.hasAnyPermissions(key.getKey(), key.getValue().toArray(new String[0])).getCheckedData();
    //             }
    //
    //         });
    //
    // @Override
    // public boolean hasPermission(String permission) {
    //     return hasAnyPermissions(permission);
    // }
    //
    // @Override
    // @SneakyThrows
    // public boolean hasAnyPermissions(String... permissions) {
    //     return hasAnyPermissionsCache.get(new KeyValue<>(getLoginUserId(), Arrays.asList(permissions)));
    // }
    //
    // @Override
    // public boolean hasRole(String role) {
    //     return hasAnyRoles(role);
    // }
    //
    // @Override
    // @SneakyThrows
    // public boolean hasAnyRoles(String... roles) {
    //     return hasAnyRolesCache.get(new KeyValue<>(getLoginUserId(), Arrays.asList(roles)));
    // }
    //
    // @Override
    // public boolean hasScope(String scope) {
    //     return hasAnyScopes(scope);
    // }
    //
    // @Override
    // public boolean hasAnyScopes(String... scope) {
    //     LoginUser user = SecurityFrameworkUtils.getLoginUser();
    //     if (user == null) {
    //         return false;
    //     }
    //     return CollUtil.containsAny(user.getScopes(), Arrays.asList(scope));
    // }

}
