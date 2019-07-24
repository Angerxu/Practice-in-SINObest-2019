#  7月24日实习日志  
*2019年7月24日 星期三*  
## 学习内容  
1.git工作流相关内容  
  ```
git rm --cached -r <File>
# -cached：在工作区暂存文件而在暂存区删除（不加入暂存区） 
  -r 递归删除文件目录及路径下的所有文件  
.gitignore 文件  
使用正则表达式忽略某些文件加入暂存区。commit后会在暂存区删除符合忽略条件的文件。  
*.iml# 忽略以iml为后缀的文件  
*.cs       # 忽略所有 .cs 结尾的文件  
!ABC.cs    # 但 ABC.cs 除外  
/BLL       # 仅仅忽略项目根目录下的 BLL 文件，不包括 subdir/BLL  
build/     # 忽略 build/ 目录下的所有文件  
doc/*.txt  # 会忽略 doc/notes.txt 但不包括 doc/server/arch.txt  
  ```  
如果某些文件已经被纳入了版本管理中，则修改.gitignore是无效的。  
解决方法就是先把本地缓存删除（改变成未track状态），然后再提交：  
2.Mysql-8.0.17配置  
> 操作系统为Win7 Service Pack 1，已安装vc_redist.x64(vc++ 2015 Redistributable-14.0.23026)的情况下，配置MySQL 8.0.17出现"计算机丢失api-ms-win-crt-runtime-|1-1-0.dll"。错误在网上寻求解决方法，发现需要对操作系统打上序列号为"KB2999226"的补丁，该补丁修复了C-RUNTIME在Windows的全局设置问题。补丁安装后系统重启生效.  

补丁链接：[Microsoft KB2999226 Update](https://support.microsoft.com/en-us/help/2999226/update-for-universal-c-runtime-in-windows)    
3.MySQL基本数据类型、建立样例数据库实际操作  
  ```
tinyint, mediumint, largeint. unsigned与increment类型。  
  ```  
建立图书管理项目所需要的数据库及列表项，对表中对应列进行insert, update，select等操作。对表进行alter, drop等操作。  

## 编写代码  
1.MySQL升级到8.0，修改返回Connection的方法中的Url。  
2.建立数据库samp_db，进行数据库基本操作。  