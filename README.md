# FirstJni
Jni实战，从一个简单的java文件到最终被Android程序调用

通过修改build.gradle 里面的相关注释的方法，来实现使用ndk编译还是使用cmake进行编译。



如果需要引入其他的Android.mk  则需要将 `LOCAL_PATH ` 重新进行赋值，必须先保存第一次调用的值后面再重新赋值。

```
LOCAL_PATH :=  $(call my-dir)
MY_MIC_PATH := ${LOCAL_PATH}
include $(CLEAR_VARS)
include $(LOCAL_PATH)/../../../../VoiceManager/mk/android/jni/Android.mk

LOCAL_PATH :=  ${MY_MIC_PATH}
include $(CLEAR_VARS)
```

这样才不会破坏 NDK的调用层级

### tips

1. LOCAL_XXX 打头的其他变量默认都会使用 `LOCAL_PATH` 作为前缀 ，所以如果你需要保证 LOCAL_PATH是对的

2. 对于非LOCAL_XXX 打头 的则需要 自己手动加上 ${LOCAL_PATH} 作为前缀，比方说头文件的查找目录

   ```
   INC_DIRS = \
       -I$(LOCAL_PATH)/$(APP_LIBS_PATH)/elevoc_kernel/${TARGET_ARCH_ABI}/inc
   LOCAL_CFLAGS += $(INC_DIRS)
   ```

3. 切记导入的可能会修改 父类的 同名变量，所以需要小心使用 变量名，确保子类不会修改 父类的同名变量
4. 发现原来再 jni里面 耶可以通过执行  `ndk-build` 来执行
5. `ndk-build V=1 -B` 会把详细构建构成都输出