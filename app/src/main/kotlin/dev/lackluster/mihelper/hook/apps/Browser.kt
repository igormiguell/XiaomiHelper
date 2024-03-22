package dev.lackluster.mihelper.hook.apps

import com.highcapable.yukihookapi.hook.entity.YukiBaseHooker
import dev.lackluster.mihelper.hook.rules.browser.DebugMode
import dev.lackluster.mihelper.hook.rules.browser.DisableUpdateCheck
import dev.lackluster.mihelper.hook.rules.browser.SwitchEnv
import dev.lackluster.mihelper.utils.DexKit

object Browser : YukiBaseHooker() {
    override fun onHook() {
        DexKit.initDexKit(this)
        loadHooker(DebugMode)
        loadHooker(DisableUpdateCheck)
        loadHooker(SwitchEnv)
        DexKit.closeDexKit()
    }
}