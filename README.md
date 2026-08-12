# Miuix FloatingNavigationBar Demo

一个展示 Miuix 悬浮底栏（FloatingNavigationBar）效果的 Android 示例应用。

## 特性

- ✅ Miuix FloatingNavigationBar（类似 KernelSU 的毛玻璃悬浮底栏）
- ✅ 自动跟随系统深色/浅色模式
- ✅ 三个导航页面示例
- ✅ 完整的 Jetpack Compose UI

## 下载

在 [Releases](../../releases) 页面下载最新构建的 APK。

每次推送代码后，GitHub Actions 会自动构建，你可以在 [Actions](../../actions) 页面下载构建产物。

## 构建要求

- Android Studio Ladybug (2024.2.1) 或更高版本
- JDK 21
- Android SDK 35

## 核心代码

```kotlin
Scaffold(
    bottomBar = {
        FloatingNavigationBar {
            navItems.forEachIndexed { index, item ->
                FloatingNavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = { selectedIndex = index },
                    icon = item.icon,
                    label = item.label
                )
            }
        }
    }
) { paddingValues ->
    // 页面内容
}
```

## 参考

- [Miuix 官方文档](https://miuix.pages.dev)
- [Miuix GitHub](https://github.com/miuix-kotlin-multiplatform/miuix)
- [在线演示](https://miuix.pages.dev/compose/index.html?id=navigationBar)

## 许可

Apache 2.0
