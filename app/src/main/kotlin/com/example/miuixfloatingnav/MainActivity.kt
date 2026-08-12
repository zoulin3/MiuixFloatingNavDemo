package com.example.miuixfloatingnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import top.yukonga.miuix.kmp.basic.FloatingNavigationBar
import top.yukonga.miuix.kmp.basic.FloatingNavigationBarItem
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.icons.Home
import top.yukonga.miuix.kmp.icon.icons.Info
import top.yukonga.miuix.kmp.icon.icons.Settings
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.utils.BackHandler
import top.yukonga.miuix.kmp.utils.MiuixPopupUtil.Companion.dismissDialog

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val controller = remember { 
        top.yukonga.miuix.kmp.theme.ThemeController(
            top.yukonga.miuix.kmp.theme.ColorSchemeMode.System
        ) 
    }
    
    MiuixTheme(controller = controller) {
        MainScreen()
    }
}

data class NavItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun MainScreen() {
    var selectedIndex by remember { mutableIntStateOf(0) }
    
    val navItems = listOf(
        NavItem("首页", MiuixIcons.Home),
        NavItem("关于", MiuixIcons.Info),
        NavItem("设置", MiuixIcons.Settings)
    )
    
    BackHandler {
        dismissDialog()
    }
    
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "当前页面：${navItems[selectedIndex].label}",
                    style = MiuixTheme.textStyles.title1
                )
                Text(
                    text = "Miuix 悬浮底栏示例",
                    style = MiuixTheme.textStyles.body2,
                    modifier = Modifier.padding(top = top.yukonga.miuix.kmp.theme.MiuixTheme.Dimension.PaddingDefault)
                )
            }
        }
    }
}
