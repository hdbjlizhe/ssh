package com.zhelee.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhelee.info.domain.FtpBaseFile;

public interface FtpBaseFileRepository extends JpaRepository<FtpBaseFile, Integer> {

}
