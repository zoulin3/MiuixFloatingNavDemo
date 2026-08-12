# 如何启用 GitHub Actions 自动构建

## ✅ 项目已成功上传到 GitHub！

**仓库地址：** https://github.com/zoulin3/MiuixFloatingNavDemo

---

## 🚀 启用自动构建（2 分钟完成）

### 方法 1：通过 GitHub 网页添加 Workflow（推荐）

1. **打开你的仓库**：https://github.com/zoulin3/MiuixFloatingNavDemo

2. **创建 workflow 文件**：
   - 点击仓库页面的 **Actions** 标签
   - 点击 **set up a workflow yourself**
   - 删除默认内容，复制粘贴下面的配置：

```yaml
name: Build APK

on:
  push:
    branches: [ main, master ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v4
    
    - name: Set up JDK 21
      uses: actions/setup-java@v4
      with:
        java-version: '21'
        distribution: 'temurin'
        
    - name: Setup Gradle
      uses: gradle/actions/setup-gradle@v3
      
    - name: Grant execute permission for gradlew
      run: chmod +x gradlew
      
    - name: Build with Gradle
      run: ./gradlew assembleDebug
      
    - name: Upload APK
      uses: actions/upload-artifact@v4
      with:
        name: miuix-floating-nav-demo
        path: app/build/outputs/apk/debug/app-debug.apk
```

3. **提交文件**：
   - 文件名保持默认：`.github/workflows/main.yml`
   - 点击右上角 **Commit changes...**
   - 点击 **Commit changes**

4. **等待构建完成**：
   - 会自动跳转到 Actions 页面
   - 等待 3-5 分钟（第一次构建较慢）
   - 构建完成后点击 workflow 名称
   - 在 Artifacts 区域下载 `miuix-floating-nav-demo.zip`
   - 解压得到 `app-debug.apk`

---

### 方法 2：手动触发构建（如果 workflow 已存在）

1. 打开：https://github.com/zoulin3/MiuixFloatingNavDemo/actions
2. 选择左侧的 **Build APK** workflow
3. 点击右侧 **Run workflow** 按钮
4. 点击绿色的 **Run workflow**
5. 等待构建完成后下载 APK

---

### 方法 3：推送新代码自动触发

每次你推送新代码到 `main` 分支，GitHub Actions 会自动构建并生成 APK。

---

## 📦 下载构建好的 APK

1. 打开：https://github.com/zoulin3/MiuixFloatingNavDemo/actions
2. 点击最新的成功构建（绿色 ✓）
3. 滚动到页面底部的 **Artifacts**
4. 点击 `miuix-floating-nav-demo` 下载
5. 解压 ZIP 文件，得到 `app-debug.apk`
6. 安装到手机查看效果

---

## 🔧 Token 权限说明

你提供的 token 没有 `workflow` 权限，所以无法通过 API 自动创建 workflow 文件。

**建议操作**：
1. 使用上面的方法 1 手动添加（最简单）
2. 或者创建一个新的 token，勾选 `workflow` 权限

---

## 📝 仓库信息

- **仓库名称**：MiuixFloatingNavDemo
- **仓库地址**：https://github.com/zoulin3/MiuixFloatingNavDemo
- **可见性**：公开（Public）
- **描述**：Miuix FloatingNavigationBar Demo - 小米 HyperOS 风格的悬浮底栏示例

---

## 🎊 完成！

项目已经成功上传到 GitHub，你现在可以：
✅ 查看在线代码
✅ 添加 GitHub Actions 自动构建
✅ 邀请他人协作
✅ 克隆到其他设备

有问题可以随时问我！
