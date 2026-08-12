#!/bin/bash

echo "========================================="
echo "  Miuix FloatingNavigationBar 构建脚本"
echo "========================================="
echo ""

PROJECT_DIR="/sdcard/MiuixFloatingNavDemo"

cd "$PROJECT_DIR" || exit 1

echo "📦 开始构建项目..."
echo ""

# 清理旧的构建
echo "🧹 清理旧构建..."
./gradlew clean

echo ""
echo "🔨 构建 Debug APK..."
./gradlew assembleDebug

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ 构建成功！"
    echo ""
    echo "📱 APK 位置："
    echo "   $PROJECT_DIR/app/build/outputs/apk/debug/app-debug.apk"
    echo ""
    echo "安装命令："
    echo "   adb install -r app/build/outputs/apk/debug/app-debug.apk"
else
    echo ""
    echo "❌ 构建失败，请检查错误信息"
    exit 1
fi
