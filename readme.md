#在本地初始化一个仓库
```
git init
```
#指定要跟踪的文件(只有跟踪的文件，git才知道他们的状态）
```
#Git基础
##获取仓库
###git add 文件名
```
###进行初始提交
```
git commit -m 'initial project version'
```
###克隆现有的存储库
```
git clone https://github.com/ExcelStatic/
```
###可以对克隆的任务进行重命名 
```
git clone https://github.com/ExcelStatic/ 本地名称
```
##记录每次更新到仓库
###使用git status 检查文件的状态（只会显示有更新的文件的状态）
```
git status
```
###git status -s 简略信息显示 git的状态分为四种：Untracked,Unmodified,Modified,Staged
```
git status -s
```
###忽略文件
    让git忽略显示某些文件,如在.gitignore配置一下内偶然，忽略.a,.o后缀的文件
    ```
    cat .gitignore
    *.[oa]
    ````
###查看已更改但尚未暂存的内容
```
git diff
```
###将分阶段更改与上次提交进行比较 
```
git diff -staged
```
#删除文件
```
rm PROJECTS.md
```
###移动文件，重命名
```
git mv file_from file_to
```
//这个操作相当于运行了如下命令
```
git rm README.md
git add READ
```
##查看历史
###查看项目提交历史
```
git log
```
##撤销提交操作
###撤销提交操作
```
git commit --amend
```
##远程仓库
###添加远程仓库
```
git remote //查看远程仓库
git remote add pb https://github.com/paulbone/ticgit  //添加一个远程仓库，别名设置为pb
git remote -v //查看远程仓库的所有版本，和别名
```
###拉取远程Paul的仓库中有但你没有的信息 git fetch [remote-name]
```
git fetch pb
git clone		//clone命令，会自动设置添加远程仓库名为origin
git fetch		//命令会将数据拉到本地仓库，当不会自动合并或修改当前操作。需要手动合并
git pull 		//命令会将数据拉倒本仓库，并且进行合并
```
###推送到远程仓库
```
git push origin master
```
###查看远程仓库
```
git remote show origin
```
###远程仓库的移除和重命名
```
git remote rename pb paul		//将pb重命名为paul
git remote rm paul			//将paul仓库移除
```
##打标签
###列出标签
```
git tag
```
###附注标签
```
git tag -a v1.3 -m 'my version 1.4'  //创建一个标签，并设置信息
git show v1.4			     //显示tag信息
```
###共享远程标签
```
git push origin [tagname]	//推送指定标签
git push origin -tags 	//推送所有标签
```
##Git别名
###创建别名
```
git config --global alias.co checkout	//将checkout的别名设置为co
git config --global alias.br branch 	//将branch的别名设置为br
git config --global alias.ci commit	//将commit的别名设置为commit
git config --global alias.st status 	//将status的别名设置为commit
//这意味着在输入git commit时，只需要输入git ci
```
#Git分支
##分支创建
```
git branch testing		//创建一个以testing命名的分支
git checkout testing		//切换到一个已存在的testing分支
```
##合并分支
```
git merge [分支名]		//合并分支
git branch -d [分知名]		//删除分支
```

##分支管理
···
git branch		//查看分支
git branch -v 		//查看分支详细信息
git branch --merged	//查看已经合并的分支
git branch --no-merged	//查看为合并的分支
```
##分支开发工作流
###长期分支
##远程分支
```
git remote show (remote-name)		//显示远程分支
git push origin [远程分支名]		//推送远程分支名
```
###删除分支
```
git push origin --delete [远程分支名]	//删除远程连接的远程分支
```
*详情请看http://git-scm.com/book/zh/v2*


