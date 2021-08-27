// To parse this JSON data, do
//
//     final IosAadhaarModel = IosAadhaarModelFromMap(jsonString);

import 'dart:convert';

class IosAadhaarModel {
  IosAadhaarModel({
    this.mobileHash,
    this.isEmailVerified,
    this.imagebase64,
    this.sharecode,
    this.maskedAahaarNumber,
    this.father,
    this.gender,
    this.zipFileBase64,
    this.address,
    this.zipFilePath,
    this.isXmlVerify,
    this.genDate,
    this.dob,
    this.name,
    this.isMobileVerified,
    this.isError,
    this.emailHash,
    this.addressCareof,
    this.addressHouse,
    this.addressLoc,
    this.addressStreet,
    this.addressLandmark,
    this.addressVtc,
    this.addressPc,
    this.addressPo,
    this.addressSubdist,
    this.addressDist,
    this.addressState,
    this.addressCountry,
    this.message,
  });

  String mobileHash;
  bool isEmailVerified;
  String imagebase64;
  String sharecode;
  String maskedAahaarNumber;
  String father;
  String gender;
  String zipFileBase64;
  String address;
  String zipFilePath;
  bool isXmlVerify;
  String genDate;
  String dob;
  String name;
  bool isMobileVerified;
  bool isError;
  String emailHash;
  String addressCareof;
  String addressHouse;
  String addressLoc;
  String addressStreet;
  String addressLandmark;
  String addressVtc;
  String addressPc;
  String addressPo;
  String addressSubdist;
  String addressDist;
  String addressState;
  String addressCountry;
  String message;


  static IosAadhaarModel fromMap(Map<dynamic, dynamic> map) {
    return IosAadhaarModel(
      mobileHash: map["mobileHash"]?? '',
      isEmailVerified: map["isEmailVerified"]?? false,
      imagebase64: map["imagebase64"]?? '',
      sharecode: map["sharecode"]?? '',
      maskedAahaarNumber: map["maskedAahaarNumber"]?? '',
      father: map["father"]?? '',
      gender: map["gender"]?? '',
      zipFileBase64: map["zipFileBase64"]?? '',
      address: map["address"]?? '',
      zipFilePath: map["zipFilePath"]?? '',
      isXmlVerify: map["isXmlVerify"]?? false,
      genDate: map["genDate"]?? '',
      dob: map["dob"]?? '',
      name: map["name"]?? '',
      isMobileVerified: map["isMobileVerified"]?? false,
      isError: map["isError"]?? false,
      emailHash: map["emailHash"]?? '',
      addressCareof: map["address_careof"]?? '',
      addressHouse: map["address_house"]?? '',
      addressLoc: map["address_loc"]?? '',
      addressStreet: map["address_street"]?? '',
      addressLandmark: map["address_landmark"]?? '',
      addressVtc: map["address_vtc"]?? '',
      addressPc: map["address_pc"]?? '',
      addressPo: map["address_po"]?? '',
      addressSubdist: map["address_subdist"]?? '',
      addressDist: map["address_dist"]?? '',
      addressState: map["address_state"]?? '',
      addressCountry: map["address_country"]?? '',
      message: map["message"]?? '',
    );
  }
}
