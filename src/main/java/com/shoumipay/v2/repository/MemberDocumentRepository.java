package com.shoumipay.v2.repository;

import com.shoumipay.v2.domain.docs.MemberDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberDocumentRepository extends MongoRepository<MemberDocument, Long> {
    List<MemberDocument> findByMemberIdAndType(Long memberId, String type);
    Long countByMemberIdAndType(Long memberId, String type);
}