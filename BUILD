# bgfx.bazel - bgfx building in bazel
# Author: Alex Rozgo <alex.rozgo@gmail.com>

load("@rules_cc//cc:defs.bzl", "cc_binary", "cc_library", "objc_library")

load(
    "@build_bazel_rules_apple//apple:macos.bzl",
    "macos_application",
)
load(
    "@build_bazel_rules_apple//apple:versioning.bzl",
    "apple_bundle_version",
)

package(default_visibility = ["//visibility:public"])

exports_files(glob([
    "examples/common/**",
    "examples/29-debugdraw/**",
]))

srcs = [
    "src/bgfx.cpp",
    "src/debug_renderdoc.cpp",
    "src/dxgi.cpp",
    "src/glcontext_egl.cpp",
    "src/glcontext_glx.cpp",
    "src/glcontext_wgl.cpp",
    "src/glcontext_html5.cpp",
    "src/nvapi.cpp",
    "src/renderer_d3d11.cpp",
    "src/renderer_d3d12.cpp",
    "src/renderer_d3d9.cpp",
    "src/renderer_gl.cpp",
    "src/renderer_gnm.cpp",
    "src/renderer_noop.cpp",
    "src/renderer_nvn.cpp",
    "src/renderer_vk.cpp",
    "src/shader_dx9bc.cpp",
    "src/shader_dxbc.cpp",
    "src/shader_spirv.cpp",
    "src/topology.cpp",
    "src/vertexdecl.cpp",
]

srcs_osx = [
    "src/glcontext_eagl.mm",
    "src/glcontext_nsgl.mm",
    "src/renderer_mtl.mm",
]

cc_library(
    name = "bgfx",
    srcs = srcs + glob([
        "src/**/*.h",
        "src/**/*.inl",
        "3rdparty/dear-imgui/**/*.cpp",
        "3rdparty/meshoptimizer/src/**/*.cpp",
    ]),
    hdrs = glob([
        "**/*.h",
        "**/*.inl",
    ]),
    defines = [
        "BGFX_CONFIG_RENDERER_VULKAN=0",
        "BGFX_CONFIG_RENDERER_METAL=1",
    ],
    includes = [
        "3rdparty",
        "3rdparty/khronos",
        "include",
    ],
    copts = [
    ],
    visibility = ["//visibility:public"],
    deps = [
        "//bimg",
    ],
)

objc_library(
    name = "bgfx-osx",
    srcs = srcs_osx + glob([

    ]),
    hdrs = glob([
        "**/*.h",
        "**/*.inl",
    ]),
    defines = [
        "BGFX_CONFIG_RENDERER_VULKAN=0",
        "BGFX_CONFIG_RENDERER_METAL=1",
    ],
    includes = [
        "include",
    ],
    copts = [
        "-fno-objc-arc",
    ],
    visibility = ["//visibility:public"],
    deps = [
        ":bgfx",
    ],
)

cc_library(
    name = "common",
    srcs = glob(["examples/common/**/*.cpp"]),
    hdrs = glob(["examples/common/**/*.h"]),
    defines = [
        "ENTRY_CONFIG_IMPLEMENT_MAIN=1",
        "BGFX_CONFIG_RENDERER_VULKAN=0",
        "BGFX_CONFIG_RENDERER_METAL=1",
    ],
    includes = [
        "examples/common",
    ],
    deps = [
        ":bgfx",
    ],
)

objc_library(
    name = "common-osx",
    srcs = glob(["examples/common/**/*.mm"]),
    hdrs = glob(["examples/common/**/*.h"]),
    defines = [
        "ENTRY_CONFIG_IMPLEMENT_MAIN=1",
        "BGFX_CONFIG_RENDERER_VULKAN=0",
        "BGFX_CONFIG_RENDERER_METAL=1",
    ],
    includes = [
        "examples/common",
    ],
    copts = [
        "-fno-objc-arc",
    ],
    sdk_frameworks = [
        "QuartzCore",
        "Cocoa",
        "Metal",
    ],
    deps = [
        ":common",
        ":bgfx-osx",
    ],
)

examples_deps = [
    ":common",
]

examples_deps_osxs = [
    ":common",
    ":common-osx",
]

examples_linkopts = [
    "-lX11",
    "-lGL",
    "-lpthread",
    "-ldl",
]

examples_linkopts_osx = [
    "-lpthread",
    "-ldl",
]

cc_binary(
    name = "14-shadowvolumes",
    srcs = ["examples/14-shadowvolumes/shadowvolumes.cpp"],
    linkopts = examples_linkopts,
    deps = examples_deps,
)

cc_binary(
    name = "15-shadowmaps-simple",
    srcs = ["examples/15-shadowmaps-simple/shadowmaps_simple.cpp"],
    linkopts = examples_linkopts,
    deps = examples_deps,
)

cc_binary(
    name = "22-windows",
    srcs = ["examples/22-windows/windows.cpp"],
    linkopts = examples_linkopts,
    deps = examples_deps,
)

cc_binary(
    name = "29-debugdraw",
    srcs = ["examples/29-debugdraw/debugdraw.cpp"],
    linkopts = examples_linkopts,
    deps = examples_deps,
)

cc_binary(
    name = "29-debugdraw-osx",
    srcs = ["examples/29-debugdraw/debugdraw.cpp"],
    linkopts = examples_linkopts_osx,
    deps = examples_deps_osxs,
)

cc_binary(
    name = "30-picking",
    srcs = ["examples/30-picking/picking.cpp"],
    linkopts = examples_linkopts,
    deps = examples_deps,
)
