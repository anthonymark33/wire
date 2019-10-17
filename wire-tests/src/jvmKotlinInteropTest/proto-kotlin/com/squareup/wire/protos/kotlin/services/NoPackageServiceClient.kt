// Code generated by Wire protocol buffer compiler, do not edit.
// Source file: service_without_package.proto
package com.squareup.wire.protos.kotlin.services

import com.squareup.wire.GrpcCall
import com.squareup.wire.Service
import com.squareup.wire.WireRpc

interface NoPackageServiceClient : Service {
  @WireRpc(
    path = "/NoPackageService/NoPackageMethod",
    requestAdapter = "com.squareup.wire.protos.kotlin.services.NoPackageRequest#ADAPTER",
    responseAdapter = "com.squareup.wire.protos.kotlin.services.NoPackageResponse#ADAPTER"
  )
  fun NoPackageMethod(): GrpcCall<NoPackageRequest, NoPackageResponse>
}
