package com.info.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.info.domain.entity.FtpBaseFile;

public interface FtpBaseFileRepository extends JpaRepository<FtpBaseFile, Integer> {

}
